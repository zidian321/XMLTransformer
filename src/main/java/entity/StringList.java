package entity;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "strings")
@XmlAccessorType(XmlAccessType.FIELD)
public class StringList {

    
    @XmlElement(name = "string")
    private ArrayList<StringObj> objList;
 
 public ArrayList<StringObj> getObjList() {
  return objList;
 }
 
 public void setObjList(ArrayList<StringObj> objList) {
  this.objList = objList;
 }
 
}
