
public class test {

    public static String removeAccents(String str) {
        String[] AccentsMap = {
          "aàảãáạăằẳẵắặâầẩẫấậ",
          "AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬ",
          "dđ", "DĐ",
          "eèẻẽéẹêềểễếệ",
          "EÈẺẼÉẸÊỀỂỄẾỆ",
          "iìỉĩíị",
          "IÌỈĨÍỊ",
          "oòỏõóọôồổỗốộơờởỡớợ",
          "OÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢ",
          "uùủũúụưừửữứự",
          "UÙỦŨÚỤƯỪỬỮỨỰ",
          "yỳỷỹýỵ",
          "YỲỶỸÝỴ"    
        };
        for (int i = 0; i < AccentsMap.length; i++) {
            str = str.replaceAll('[' + AccentsMap[i].substring(1) + ']', Character.toString(AccentsMap[i].charAt(0)));
        }
        return str;
    }

    public static void main(String[] args) {
        
        String[] tmp = "od1,cus1,cus,cus,2,Trần,Lộc,6/5/2003,0337961759,ad1,admin,admin,0,Trần,Lộc,6/5/2003,0337961759,3,1/1/1,60.0,PRD1,Bút bi,2.0,Bút mực,10,PRD2,Bút chì,1.0,Bút chì 2B,10,PRD3,Thước thẳng 20cm,3.0,Thước kẻ,10".split(",");

        System.out.println(tmp[20 + (1 * 5) + 5]);
        
    }
}
