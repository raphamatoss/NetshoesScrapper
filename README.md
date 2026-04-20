# 🛒 Netshoes Scrapper
 
Scraper das **Ofertas do Dia** do site [Netshoes](https://www.netshoes.com.br/), desenvolvido em Java com Selenium WebDriver.
 
Coleta automaticamente os produtos em oferta e extrai: **nome**, **preço**, **descrição** e **URL da imagem** de cada um.
 
---
 
## 📋 Pré-requisitos
 
Antes de compilar, certifique-se de ter instalado:
 
- [Java JDK 25+](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven 3.8+](https://maven.apache.org/download.cgi)
- [Google Chrome](https://www.google.com/chrome/) (versão atualizada)
 
---
 
## 📁 Estrutura do Projeto
 
```
NetshoesScrapper/
├── src/
│   └── main/
│       └── java/
│           └── scrapper/
│               ├── Main.java       # Ponto de entrada
│               ├── Scrapper.java   # Lógica de scraping
│               └── Produto.java    # Modelo de dados
├── pom.xml
└── README.md
```
 
---
 
## ⚙️ Configuração
 
### Clone o repositório
 
```bash
git clone https://github.com/raphamatoss/NetshoesScrapper.git
cd NetshoesScrapper
```
 
## ▶️ Execução
 
Na raiz do projeto, onde se encontra o `pom.xml`, gere o `.jar` e o execute diretamente com:
 
```bash
mvn package
java -jar target/NetshoesScrapper-1.0-SNAPSHOT.jar
```
 
---
 
## 📦 Dependências
 
| Dependência       | Versão  | Descrição                        |
|-------------------|---------|----------------------------------|
| selenium-java     | 4.43.0  | Automação do navegador           |
 
Gerenciadas automaticamente pelo Maven via `pom.xml`.
 
---
 
## 🧩 Como funciona
 
1. Abre a página inicial da Netshoes com o ChromeDriver
2. Localiza os slides do carrossel **"Ofertas do Dia"** (excluindo duplicatas do Swiper)
3. Coleta a URL de cada produto
4. Acessa cada URL e extrai nome, preço, descrição e imagem
5. Exibe os dados no console e encerra o navegador
---
