
package messageboard.client.jaxws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "LengthExceededException", targetNamespace = "http://server.messageboard/")
public class LengthExceededException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private LengthExceededException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public LengthExceededException_Exception(String message, LengthExceededException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public LengthExceededException_Exception(String message, LengthExceededException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: messageboard.client.jaxws.LengthExceededException
     */
    public LengthExceededException getFaultInfo() {
        return faultInfo;
    }

}
