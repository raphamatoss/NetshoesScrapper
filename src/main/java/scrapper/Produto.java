package scrapper;

/**
 * Representa um produto extraído do site
 * <a href="https://www.netshoes.com.br/">Netshoes</a>.
 *
 * <p>Armazena as informações básicas de um produto, como nome, preço,
 * descrição e URL da imagem.</p>
 *
 * @author Raphael Matos
 */
public class Produto {
    /** Nome do produto. */
    private String nome;
    /** Preço do produto, formatado como exibido no site (ex: "R$ 269,99"). */
    private String preco;
    /** Descrição do produto. */
    private String descricao;
    /** URL da imagem principal do produto. */
    private String imagemUrl;

    /**
     * Construtor vazio. Utilize os setters para definir os campos.
     */
    public Produto () {}

    /**
     * Cria um produto com todos os campos preenchidos.
     *
     * @param nome      nome do produto
     * @param preco     preço formatado do produto (ex: "R$ 269,99")
     * @param descricao descrição do produto
     * @param imagemUrl URL da imagem principal do produto
     */
    public Produto(String nome, String preco, String descricao, String imagemUrl) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    /**
     * Retorna uma representação textual do produto.
     *
     * @return string formatada com todos os campos do produto
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Produto: ").append(nome).append("\n");
        sb.append("Preco: ").append(preco).append("\n");
        sb.append("Descricao: ").append(descricao).append("\n");
        sb.append("URL Imagem: ").append(imagemUrl).append("\n");
        return sb.toString();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
