import java.util.Scanner;

public class Text
{
    private String header;
    private String text = "";

    private String getHeader()
    {
        return header;
    }

    private String getText()
    {
        return text;
    }

    private Text(){}

    private Text(Word word)
    {
        header = word.getWord();
    }

    private Text(Sentence sentence)
    {
        header = sentence.getSentence();
    }

    private void addWord(Word word)
    {
        text = text + " " + word.getWord();
    }

    private void addSentence(Sentence sentence)
    {
        text = text + " " + sentence.getSentence();
    }

    public static void main(String[] args) {
        Text text = new Text();
        Sentence sentence = new Sentence();
        Scanner in = new Scanner(System.in);
        int kod;
        do{
        System.out.println(" Нажмите '1' - чтобы составить заголовок\n" +
                            " Нажмите '2' - чтобы составить текст\n" +
                            " Нажмите '3' - чтобы дополнить текст\n" +
                            " Нажмите '4' - чтобы показать текст\n" +
                            " Нажмите '5' - чтобы показать заголовок\n" +
                            " Нажмите любое другое число, чтобы просмотреть заголовок с текстом и выйти");
        System.out.println(" Что делаем?");
            kod = Integer.parseInt(in.nextLine());
        switch (kod)
        {
            case 1:
                System.out.println(" Нажмите '1' - чтобы составить заголовок из предложения\n" +
                                    " Нажмите '2' - чтобы составить заголовок из слова");
                do {
                    System.out.println(" Что делаем?");
                    kod = Integer.parseInt(in.nextLine());
                    if(kod != 1 && kod != 2)
                    {
                        System.out.println( " Ошибка. Пожалуйста, введите '1' или '2'");
                    }
                }while (kod != 1 && kod != 2);
                switch (kod) {
                    case 1:
                        do {
                        System.out.print(" Нажмите '1' - чтобы добавить слово в предложение названия заголовка\n" +
                                        " Нажмите '2' - чтобы закончить составлять название заголовка\n");
                            do {
                                System.out.println(" Что делаем?");
                                kod = Integer.parseInt(in.nextLine());
                                if (kod != 1 && kod != 2) {
                                    System.out.println(" Ошибка. Пожалуйста, введите '1' или '2'");
                                }
                            } while (kod != 1 && kod != 2);
                            switch (kod) {
                                case 1:
                                    System.out.println( " Введите слово, которое  хотите добавить в предложение названия заголовка: ");
                                    sentence.addWord(new Word(in.nextLine()));
                                    break;
                                case 2:
                                    text = new Text(sentence);
                                    break;
                            }
                        }while (kod != 2);
                        break;
                    case 2:
                        System.out.print(" Введите название заголовка: ");
                        text = new Text(new Word(in.nextLine()));
                        break;
                }
                kod = 0;
                break;
            case 2:
                sentence = new Sentence();
                do{
                System.out.print(" Нажмите '1' - Чтобы добавить слово в предложение\n" +
                                " Нажмите '2' - Чтобы закончить составление текста\n");
                    do {
                        System.out.println(" Что делаем?");
                        kod = Integer.parseInt(in.nextLine());
                        if (kod != 1 && kod != 2) {
                            System.out.println(" Ошибка. Пожалуйста, введите '1' или '2'");
                        }
                    } while (kod != 1 && kod != 2);
                    switch (kod) {
                        case 1:
                            System.out.print(" Введите слово, которое хотите добавить к предложению: ");
                            sentence.addWord(new Word(in.nextLine()));
                            break;
                        case 2:
                            text.addSentence(sentence);
                            break;
                    }
                }while (kod != 2);
                kod = 0;
                break;
            case 3:
                do{
                System.out.println(" Нажмите '1' - чтобы добавить в текст предложение\n" +
                                    " Нажмите '2' - чтобы добавить в текст слово\n" +
                                    " Нажмите '3' - чтобы закончить добавление в текст предложений и слов");
                    do {
                        System.out.println(" Что делаем?");
                        kod = Integer.parseInt(in.nextLine());
                        if (kod != 1 && kod != 2 && kod != 3) {
                            System.out.println(" Ошибка. Пожалуйста, введите '1' или '2' или '3'");
                        }
                    } while (kod != 1 && kod != 2 && kod != 3);
                    switch (kod)
                    {
                        case 1:
                            sentence = new Sentence();
                            do{
                            System.out.print(" Нажмите '1' - чтобы добавить слово в предложение\n" +
                                    " Нажмите '2' - чтобы закончить составлять предлоожение\n");
                                do {
                                    System.out.println(" Что делаем?");
                                    kod = Integer.parseInt(in.nextLine());
                                    if (kod != 1 && kod != 2) {
                                        System.out.println(" Ошибка. Пожалуйста, введите '1' или '2'");
                                    }
                                } while (kod != 1 && kod != 2);
                                switch (kod) {
                                    case 1:
                                        System.out.print(" Введите слово, которое хотите добавить к предложению: ");
                                        text.addWord(new Word(in.nextLine()));
                                        break;
                                    case 2:
                                        text.addSentence(sentence);
                                        break;
                                }
                            }while (kod != 2);
                            break;
                        case 2:
                            System.out.print(" Введите слово, которое хотите добавить к тексту: ");
                            text.addWord(new Word(in.nextLine()));
                            break;
                    }
                }while (kod != 3);
                kod = 0;
                break;
            case 4:
                System.out.println(" Текст: " + text.getText());
                kod = 0;
                break;
            case 5:
                System.out.println(" Заголовок: " + text.getHeader());
                kod = 0;
                break;
            default:
                System.out.println(" Заголовок: " + text.getHeader());
                System.out.println(" Текст: " + text.getText());
                kod = 1;
                break;
        }
        } while (kod == 0);
    }
}
