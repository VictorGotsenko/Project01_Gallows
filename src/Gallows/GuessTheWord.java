package Gallows;


import java.io.*;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class GuessTheWord {

    // Характеристики (состояние), свойства, поля.
    private static String sFilePath; // path to dictionary file
    private String sGuessTheWord; // This word enigma


    // Constructor
    GuessTheWord(String sDictPath) {
        this.sFilePath = sDictPath;
    }

    //   Методы (поведение)

    //Возвращает количество строчек в файле со словами
    public static int NumLine () throws IOException {
        int iCountLines = 0;
        int iLenghtWord = 1;
        String s; // temp var
        File file = new File(sFilePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        while ((s = br.readLine()) != null) {                        // count the number of lines in the dictionary
            ++iCountLines;
            s = s.toLowerCase();
            if (iLenghtWord < s.length()) {                         // получаю длинну слова
                iLenghtWord = s.length();
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!(ch >= 'а' && ch <= 'я')){   // ||(ch == 'ё')
                    if (ch == 'ё') break;
                    System.out.println("Файл словаря содержит недопустимое слово из не русских букв: " + s);
                    System.out.println("Работа программы завершена");
                    System.exit(0);
                }
            }
        }
        br.close();
        fr.close();
        if (iCountLines <= 5) {                     // обработка файла с малым количеством слов < 5
            System.out.println("Файл словаря содержит менее 6 слов. Для работы программы необходимо больше слов");
            System.out.println("Работа программы завершена");
            System.exit(0);
        }
        if (iLenghtWord < 5) {                     // обработка слова (менее 5 букв отбросить)
            System.out.println("Файл словаря содержит слова длинной менее 5 букв. Для работы программы необходимо слова подлиннее");
            System.out.println("Работа программы завершена");
            System.exit(0);
        }
    return iCountLines;
    }

    // Получить кол-во строк в словаре, выбрать и вернуть слово string
    public static String RndWord(int iNumLine) throws IOException {
        String sGuessTheWord = "0";
        File file = new File(sFilePath);

        Random NumLine = new Random();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        do {                                                            // iNumLine кол-во строк в файле
            int iLine = NumLine.nextInt(iNumLine);                      // generate random number
            System.out.println("random " + iLine);
            for (int i = 1; i <= iLine; i++) {
                sGuessTheWord = br.readLine();                          // read string
                sGuessTheWord = sGuessTheWord.toLowerCase();            // to lower case
            }
        } while ( sGuessTheWord.length() < 5);                         // if less 5 characters, read again
        br.close();
        fr.close();
        return sGuessTheWord;
    }




}


