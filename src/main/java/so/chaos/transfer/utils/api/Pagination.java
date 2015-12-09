package so.chaos.transfer.utils.api;

import java.io.Serializable;

/**
 * a transfer object for pagination data 
 * @author chengchaos
 *
 */
public interface Pagination extends Serializable{

    /**
     * 
     * @return
     */
    public int getFirstPage();
    
    /**
     * 
     * @return
     */
    public int getCurrentPage();
    
    /**
     * 
     * @return
     */
    public int getLastPage();
    
    /**
     * 
     * @return
     */
    public int getPageSize();
    
    /**
     * The total number of records
     * @return
     */
    public int getTotal();
    
    
}
