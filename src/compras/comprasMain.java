package compras;
import java.util.*;
public class comprasMain {
    private static List<compras> produtos = new LinkedList();
    private static Map<String,List<compras>> historicoDeCompras = new HashMap<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }
    //Menu principal para acessar as funções
    private static void menu(){
        System.out.println("=====================================");
        System.out.println("========1-Registrar produto==========");
        System.out.println("========2-Consultar produto==========");
        System.out.println("================3-Sair===============");
        System.out.println("=====================================");

        int option = input.nextInt();


        switch (option){
            case 1:
                registrar();
                break;
            case 2:
                contulta();
                break;
            case 3:
                System.out.println("Volte sempre !");
                break;
        }
    }
    //Registrar os produtos
    private static void registrar(){
        Double preço;
        String produto,login,resp;
        System.out.println("Possui cadastro ?");
        resp = input.next();

        if (resp.equalsIgnoreCase("S")){
            System.out.println("Digite o login");
            login= input.next();

            if(historicoDeCompras.containsKey(login)) {

                produtos = historicoDeCompras.get(login);
                System.out.println("Digite o produto");
                produto = input.next();
                System.out.println("preço do produto");
                preço = input.nextDouble();

                compras item = new compras(produto, preço);
                historicoDeCompras.get(login).add(item);

            }else {
                System.out.println("Login invalido!");
            }

        }else {
            System.out.println("Crie seu login");
            login= input.next();
            System.out.println("Digite o nome do produto");
            produto=input.next();
            System.out.println("Digite o preço do produto");
            preço=input.nextDouble();

            compras item = new compras(produto,preço);
            produtos.add(item);
            historicoDeCompras.put(login,produtos);

        }
        menu();

    }
    //Metodo consulta que chama o subMenu
    private static void contulta(){
        subMenu();

    }
    //Sub menu das consultas
    private static void subMenu(){
        System.out.println("=======================================");
        System.out.println("========1-Consultar todos produto======");
        System.out.println("=============2-Total gasto=============");
        System.out.println("================3-Voltar===============");
        System.out.println("=======================================");

        int option= input.nextInt();

        switch (option){
            case 1:
                System.out.println("Digite seu login");
                consultaProdutos(input.next());
                break;
            case 2:
                System.out.println("Digite seu login");
                preçoTotal(input.next());
            case 3:
                menu();
                break;
        }

    }
    //Consulta todos produtos dentro da array dentro do map pelo login
    private static void consultaProdutos(String login){
        if (historicoDeCompras.containsKey(login)) {
            for (compras item:historicoDeCompras.get(login)){
                System.out.println("Produto:"+item.getNomeDoProduto());
                System.out.println("Preço"+item.getPreçoDoProduto());
            }
        }else {
            System.out.println("Login invalido");
        }
        menu();
    }
    //Utiliza a mesma logica da consultaProdutos() e faz a soma
    private static void preçoTotal(String login) {
        Double soma = 0d;
        if (historicoDeCompras.containsKey(login)) {
            for (compras item : historicoDeCompras.get(login)) {
                soma += item.getPreçoDoProduto();
            }
            System.out.println("O preço total gasto é de:"+soma);
        }else{
            System.out.println("Login invalido");
        }
        menu();
    }
}
