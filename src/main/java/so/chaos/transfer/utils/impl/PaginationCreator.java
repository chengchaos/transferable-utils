package so.chaos.transfer.utils.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import so.chaos.transfer.utils.api.Pagination;
import so.chaos.transfer.utils.api.Range;

/**
 * 
 * @author chengchaos
 *
 */
public class PaginationCreator implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PaginationCreator.class);
    
    private static final int DEFAULT_FIRST_PAGE = 1;
    
    private static final int DEFAULT_PAGE_SIZE = 10;
    
    
    
    /**
     * 
     * @author chengchaos
     *
     */
    private static class InnerPagination implements Pagination {

        
        private static final long serialVersionUID = 1L;
        
        private final int total;
        private final int pageSize;
        private final int currentPage;
        
        private final int firstPage;
        private final int lastPage;
        
        public InnerPagination(PaginationCreator pa) {
            
            this.total = pa.total;
            this.pageSize = pa.pageSize;
            this.currentPage = pa.currentPage;
            
            this.firstPage = pa.firstPage;
            this.lastPage = pa.lastPage;
        }
        
        @Override
        public int getFirstPage() {
            return this.firstPage;
        }

        @Override
        public int getCurrentPage() {
            return this.currentPage;
        }

        @Override
        public int getLastPage() {
            return this.lastPage;
        }

        @Override
        public int getPageSize() {
            return this.pageSize;
        }

        @Override
        public int getTotal() {
            return this.total;
        }
        
    }

    

    private int total = -1;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private int currentPage = -1;

    private int firstPage = DEFAULT_FIRST_PAGE;
    private int lastPage = -1;
    
    public PaginationCreator() {
        super();
        
    }
    
    public PaginationCreator setTotal(int total) {
        this.total = total;
        return this;
    }
    
    public PaginationCreator setPageSize(int pageSize) {
        
        if (pageSize > 0) {
            //throw new IllegalStateException(" pageSize == 0");
            this.pageSize = pageSize;
        } else {
            LOGGER.error("the pageSize mast be **GT** 0, but I setting it to default value (10) ");
        }
        
        return this;
    }
    
    public PaginationCreator setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }
    

    private void shrink() {
        
        if (total < 0) {
            throw new IllegalStateException(" total mast be a natural number ");
        }
        
        if (currentPage < 1) {
            throw new IllegalStateException(" currentPage mast be a natural number ");
        }
        
        if (currentPage < firstPage) {
            currentPage = firstPage;
        }
        
        lastPage = (total / pageSize);
        
        if ((lastPage * pageSize) != total) {
            lastPage += 1;
        }
        
        if (lastPage <= 0) {
            lastPage = firstPage;
        }
        
        if (currentPage > lastPage) {
            currentPage = lastPage;
        }
        
    }
    
    /**
     * 
     * @return
     */
    public final Range createRange() {
        
        this.shrink();
        
        return Ranges.valueOfStartAndLength(
                (this.currentPage -1) * this.pageSize , this.pageSize);
    }
    
    /**
     * 
     * @return
     */
    public final Pagination createPatination() {
        
        this.shrink();
        
        return new PaginationCreator.InnerPagination(this);
    }
    
    
}
