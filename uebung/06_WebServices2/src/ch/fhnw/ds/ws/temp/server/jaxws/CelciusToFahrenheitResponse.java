
package ch.fhnw.ds.ws.temp.server.jaxws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "celciusToFahrenheitResponse", namespace = "http://server.temp.ws.ds.fhnw.ch/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "celciusToFahrenheitResponse", namespace = "http://server.temp.ws.ds.fhnw.ch/")
public class CelciusToFahrenheitResponse {

    @XmlElement(name = "arg", namespace = "")
    private BigDecimal arg;

    /**
     * 
     * @return
     *     returns BigDecimal
     */
    public BigDecimal getArg() {
        return this.arg;
    }

    /**
     * 
     * @param arg
     *     the value for the arg property
     */
    public void setArg(BigDecimal arg) {
        this.arg = arg;
    }

}
