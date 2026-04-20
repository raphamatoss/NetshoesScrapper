package scrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Realiza a extração (scraping) de produtos listados em "Ofertas do Dia" do site
 * <a href="https://www.netshoes.com.br/">Netshoes</a>.
 *
 * <p>O fluxo principal é:</p>
 * <ol>
 *   <li>Acessar a página inicial e coletar as URLs dos produtos listados em "Ofertas do Dia"</li>
 *   <li>Acessar cada URL e extrair os dados do produto</li>
 * </ol>
 *
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * WebDriver driver = new ChromeDriver();
 * Scrapper scrapper = new Scrapper(driver);
 * scrapper.run("https://www.netshoes.com.br/");
 * }</pre>
 *
 * @author Raphael Matos
 * @see Produto
 */
public class Scrapper {
    private static WebDriver driver;
    /** URLs dos produtos coletadas da seção de ofertas. */
    private ArrayList<String> produtosUrls;

    /**
     * Cria uma instância do Scrapper com o driver do Selenium.
     *
     * @param driver instância do {@link WebDriver} a ser utilizada para navegação
     */
    public Scrapper (WebDriver driver) {
        Scrapper.driver = driver;
        produtosUrls = new ArrayList<>();
    }

    /**
     * Executa o fluxo completo de scraping:
     * coleta os links dos produtos e em seguida extrai os dados de cada um.
     *
     * <p>Ao final, encerra a sessão do navegador com {@link WebDriver#quit()}.</p>
     *
     * @param url URL da página inicial a ser acessada (ex: "https://www.netshoes.com.br/")
     */
    public void run(String url) {
        driver.get(url);
        obterLinksDosProdutos();
        obterDadosDosProdutos();
        driver.quit();
    }

    /**
     * Coleta as URLs dos produtos exibidos no carrossel de ofertas do dia.
     *
     * <p>Filtra os slides duplicados gerados pelo Swiper usando o seletor
     * {@code :not(.swiper-slide-duplicate)}, garantindo URLs únicas.</p>
     */
    public void obterLinksDosProdutos() {
        List<WebElement> dailyOffers = driver.findElements(
                By.cssSelector(".daily-offer__container__slider .swiper-slide:not(.swiper-slide-duplicate)")
        );

        for (WebElement offer : dailyOffers) {
            WebElement link = offer.findElement(By.cssSelector("a[href]"));
            String href = link.getAttribute("href");
            produtosUrls.add(href);
        }
    }

    /**
     * Acessa cada URL coletada e extrai os dados do produto correspondente.
     *
     * <p>Para cada produto, são extraídos: nome, preço, descrição e URL da imagem.
     * Os dados são exibidos no console via {@link Produto#toString()}.</p>
     */
    public void obterDadosDosProdutos () {
        for (String url : produtosUrls) {
            driver.get(url);

            Produto produto = new Produto();

            produto.setNome(driver.findElement(By.cssSelector(".product-name")).getText());
            produto.setPreco(driver.findElement(By.cssSelector(".saleInCents-value")).getText());
            produto.setDescricao(driver.findElement(By.cssSelector(".features--description")).getText());
            produto.setImagemUrl(driver.findElement(By.cssSelector(".carousel-item-figure img")).getAttribute("src"));

            System.out.println(produto);
        }
    }
}
