package scrapper;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        Scrapper scrapper = new Scrapper(new ChromeDriver());
        scrapper.run("https://www.netshoes.com.br/");
    }
}
