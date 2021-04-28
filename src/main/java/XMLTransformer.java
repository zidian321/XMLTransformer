import entity.StringList;
import entity.StringObj;
import utils.StringLengthComparator;

import java.util.*;


public class XMLTransformer {
    public static void main(String[] args) throws Exception {
        StringList stringList = new JaxbReadXml().test_xml();
        Set<String> sortedMarketPlaceList = getSortedMarketPlaceList(stringList);
        StringList combineStringList = combineMarketPlace(stringList,sortedMarketPlaceList);
        new JaxbWriteXml().test_xml2(combineStringList);
    }

    private static Set<String> getSortedMarketPlaceList(StringList stringList) {

        SortedSet marketPlaceSet = new TreeSet( new StringLengthComparator());
        for(StringObj stringObj : stringList.getObjList()){
            marketPlaceSet.add(stringObj.getMarketplace());
        }
        return marketPlaceSet;
    }

    private static StringList combineMarketPlace(StringList stringList,Set<String> sortedMarketPlaceSets) {
        ArrayList<StringObj> combineObj = new ArrayList<StringObj>();
        ArrayList<StringObj> objs = stringList.getObjList();
        Set<String> keys = new HashSet<String>();
        Iterator<String> it = sortedMarketPlaceSets.iterator();
        while (it.hasNext()){
            String marketPlaceId = it.next();
            replaceStringMarketPlace(combineObj, objs, keys, marketPlaceId);
            System.out.println(marketPlaceId);
        }
        StringList combineStringList = new StringList();
        combineStringList.setObjList(combineObj);
        return combineStringList;
    }

    private static void replaceStringMarketPlace(ArrayList<StringObj> combineObj, ArrayList<StringObj> objs,
                                                 Set<String> keys, String originalMarketPlace) {
        for (StringObj stringObj : objs) {
            if (stringObj.getMarketplace().equals(originalMarketPlace)) {
                if (!keys.contains(stringObj.getLocale() + stringObj.getTag())) {
                    StringObj replaceObj = cloneAndModify(stringObj);
                    combineObj.add(replaceObj);
                    keys.add(stringObj.getLocale() + stringObj.getTag());
                }
            }
        }
    }

    private static StringObj cloneAndModify(StringObj stringObj) {
        StringObj obj = new StringObj();
        obj.setLocale(stringObj.getLocale());
        obj.setMarketplace("SellerCentral");
        obj.setStringSet(stringObj.getStringSet());
        obj.setTag(stringObj.getTag());
        obj.setText(stringObj.getText());
        return obj;
    }
}
