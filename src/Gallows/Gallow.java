package Gallows;

import java.util.LinkedHashSet;
import java.util.Set;

public class Gallow {
    // Характеристики (состояние), свойства, поля.
 //   Set<Character> linksCharEntered = new LinkedHashSet<>();    // массив для непр. введённых букв

    int iError = 0;
    //String sCharEntered = "";
    String sGallow1 = " ____";
    String sGallow2 = " |  |";
//    String sGallow3 = " |  o";
//    String sGallow4 = " | /|\\";
//    String sGallow5 = " | /`"+"\\";
    String sGallow3 = " |  ";
    String sGallow4 = " | ";
    String sGallow5 = " | ";
    String sGallow6 = " | ";
    String sGallow7 = "/|"+"\\";

    //   Методы (поведение)
    // рисую виселицу
    void GallowPrint() {
        System.out.println(sGallow1);
        System.out.println(sGallow2);
        System.out.println(sGallow3);
        System.out.println(sGallow4);
        System.out.println(sGallow5);
        System.out.println(sGallow6);
        System.out.println(sGallow7);
        System.out.println();
    }

    // Рисую поле в зависимости от кол-ва ошибок
    void GallowProceed( int iError) {

//        char[] cTmp = sCharEntered;
//        for (int i = 0; i < cTmp.length; i++) {
//            cTmp[i] == cKey
//        }
//        if (cKey != '.') {
//            sCharEntered = sCharEntered + cKey + ", ";
//        }
//        linksCharEntered.add(cKey);

       // System.out.println("Ошибки (" + iError + "):");
      //  System.out.println(linksCharEntered);
        switch (iError) {
            case 1:
                sGallow3 = " |  o";
                break;
            case 2:
                sGallow4 = " |  |";
                break;
            case 3:
                sGallow4 = " | /|";
                break;
            case 4:
                sGallow4 = " | /|\\";
                break;
            case 5:
                sGallow5 = " | /`";
                break;
            case 6:
                sGallow5 = " | /`\\";
                break;
            default:
                break;
        }
       // return iError;
    }
}
