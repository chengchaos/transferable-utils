package so.chaos.transfer.utils.api;

import java.io.Serializable;

/**
 * a transferable object of range <br />
 * 
 * @author chengchaos
 *
 */
public interface Range extends Serializable {

    /**
     * 
     * @return
     */
    public int getStart();
    
    /**
     * 
     * @return
     */
    public int getLength();
    
}
