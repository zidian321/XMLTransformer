package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
 
@XmlAccessorType(XmlAccessType.FIELD)
public class StringObj {
 
 private String locale;
 private String marketplace;
 private String tag;
 private String text;
 private String stringSet;

 public StringObj(String locale, String marketplace, String tag, String text, String stringSet) {
  this.locale = locale;
  this.marketplace = marketplace;
  this.tag = tag;
  this.text = text;
  this.stringSet = stringSet;
 }

 public String getLocale() {
  return locale;
 }

 public void setLocale(String locale) {
  this.locale = locale;
 }

 public String getMarketplace() {
  return marketplace;
 }

 public void setMarketplace(String marketplace) {
  this.marketplace = marketplace;
 }

 public String getTag() {
  return tag;
 }

 public void setTag(String tag) {
  this.tag = tag;
 }

 public String getText() {
  return text;
 }

 public void setText(String text) {
  this.text = text;
 }

 public String getStringSet() {
  return stringSet;
 }

 public void setStringSet(String stringSet) {
  this.stringSet = stringSet;
 }

 public StringObj() {
 
 }
 

 
}
