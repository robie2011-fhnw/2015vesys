
package bank.local.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "init", namespace = "http://local.bank/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "init", namespace = "http://local.bank/")
public class Init {

    @XmlElement(name = "arg0", namespace = "")
    private bank.IBank arg0;

    /**
     * 
     * @return
     *     returns IBank
     */
    public bank.IBank getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(bank.IBank arg0) {
        this.arg0 = arg0;
    }

}
