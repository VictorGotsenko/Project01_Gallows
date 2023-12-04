package Gallows;
import java.io.IOException;
import java.util.*;

public class Begin {
    public static String sFilePath;  // String - Path to Dictionary file
    private static List<Character> chArrayGuessTheWord = new ArrayList<>();        // массив для загаданного слова
    private static List<Character> chArrayRresult = new ArrayList<>();             // массив для отгаданных букв
    private static Set<Character> chArrayWrongChars = new LinkedHashSet<>();       // массив для неправ.введённых букв


    public static void main(String[] args) throws IOException {
    sFilePath = ".\\src\\Gallows\\Dictions.txt";
    String s;
    char cKey = 2;
    System.out.println("Игра - Виселица");                                    // начальное приветсвие и предложение игры
    System.out.println("Начать игру нажмите 1 / Для Выхода нажмите 2");
    Scanner cReadFromKeyboard = new Scanner(System.in);
    while (cKey != '1') {
        s = cReadFromKeyboard.nextLine();
        cKey = s.charAt(0);
        switch (cKey) {
            case '1':
                System.out.println();  // "Game"
                break;
            case '2':
                System.out.println("Goodbuy !");
                System.exit(0);
                break;
            default:
                System.out.printf("Error! Please enter 1 or 2 введено %s", cKey);
                System.out.println("");
        }
    }
    while (cKey != '2')     // начало игры, играю пока не == 2 {
        {
        GuessTheWord guessTheWord1 = new GuessTheWord(sFilePath);            // инициализация обьекта работы со словарём
        int iNumLine = GuessTheWord.NumLine();                               // получить количество строк( слов) в словаре
            System.out.println("количество строк( слов) в словаре " +  iNumLine);
        String sGuessTheWord = GuessTheWord.RndWord(iNumLine);                // Загадать слово
        char[] cGuessTheWord = sGuessTheWord.toCharArray();
        for (char c : cGuessTheWord) {                                       // слово в коллекцию букв
            chArrayGuessTheWord.add(c);
            chArrayRresult.add('_');                                         // коллекцию для отгаданных букв заполнить _ подчёркиванием
        }
        System.out.println("Загаданное слово...");
        for (int i = 0; i < chArrayRresult.size(); i++) {                    // вывод коллекции _ _ _ _
            System.out.print(chArrayRresult.get(i) + " ");
        }
        System.out.println();
       /*******************
        Игровой цикл
        *******************/
        Gallow gGame1 = new Gallow();                                       // инициализация виселицы
        gGame1.GallowPrint();                                               // печать виселицы
        int iError = 0;
        boolean isCharHere;
        boolean isWin = false;
        while (iError < 6) {                                                // играем до 6 ошибок
            isCharHere = false;
            do {
                System.out.print("Введите одну русскую букву: ");
                s = cReadFromKeyboard.nextLine();
                s = s.toLowerCase();
            }
            while (!s.matches("[а-я]"));                      // Выполнить проверку на принадлежность диапазона ru букв
            cKey = s.charAt(0);
            System.out.println();
            System.out.println("Загаданное слово...");
            for (int i = 0; i < chArrayGuessTheWord.size(); i++) {          // сравнение посимвольно загаданного слова
                if (cKey == chArrayGuessTheWord.get(i)) {
                    chArrayRresult.set(i, cKey);                            //поместить букву в массив угаданных
                    isCharHere = true;
                }
                System.out.print(chArrayRresult.get(i) + " ");              // напечатать угаданные буквы
            }

            /*
            * варианты:
            * 1 буква в слове есть - поместить в массив угаданных
            * 2 буквы в слове нет - а) буква введена первый раз - зачитываю ошибку
            *                       б) буква введена повторно - напомнить, что буква уже введена, нет ошибки
            */
            if (isCharHere == false) {
                if ( chArrayWrongChars.add(cKey) ) {
                    iError++;                                              // буквы нет, плюсую ошибку
                } else {
                    System.out.println("\n Такую букву вы уже вводили и ее нет в слове");
                }

            }
            System.out.println("Ошибки (" + iError + "):" + chArrayWrongChars);
            gGame1.GallowProceed( iError );                                // Если символа нет в слове то передаю в ошибки
            gGame1.GallowPrint();


            if (  !chArrayRresult.contains('_') ) {                   // слово отгаданно, если нет символов подчёркивания
                isWin = true;
                break;
                }
            } // end While
        if (isWin) {                                                  // если слово угадано победа, если виселица построенна - поражение.
            System.out.println("Это победа ! Вы выйграли !!!");
        } else {
            System.out.println("Вы проиграли ...");
            System.out.println("Загаданное слово : " + chArrayGuessTheWord);
        }
         /****
         очистка коллекций после игрового раунда
          ****/
        chArrayGuessTheWord.removeAll( chArrayGuessTheWord );
        chArrayRresult.removeAll(chArrayRresult);
        chArrayWrongChars.removeAll(chArrayWrongChars);
        System.out.println("      -= Игра окончена =- ");                     // блок предложения сыграть снова?
        System.out.println(" -= Но можно сыграть снова =- ");
        System.out.println("Начать игру нажмите 1 / Для Выхода нажмите 2");
        System.gc();
            cKey = 2;
        while (cKey != '1') {
            s = cReadFromKeyboard.nextLine();
            cKey = s.charAt(0);
            switch (cKey) {
                case '1':
                    System.out.println();  // " Начинаем игру снова "
                    break;
                case '2':
                    System.out.println("Goodbuy !");
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Error! Please enter 1 or 2 введено %s", cKey);
                    System.out.println("");
            }
        }
    }
}
}




