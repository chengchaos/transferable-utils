package so.chaos.transfer.utils.api;

import java.io.Serializable;

public interface Pagination extends Serializable{

	public int getFirstPage();
	
	public int getCurrentPage();
	
	public int getLastPage();
	
	public int getPageSize();
	
	/**
	 * The total number of records
	 * @return
	 */
	public int getTotal();
	
	
}
