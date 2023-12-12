package teste;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import model.entity.Hotel;
import service.HotelService;
import dto.HotelDTO;


public class MainTeste {

	public static void main(String[] args) throws ParseException, ClassNotFoundException{
		
		int opcao = -1;
		String nome, cep, logradouro, cidade, estado;
        Scanner sc = new Scanner(System.in);
        HotelService service = new HotelService();
        HotelDTO hotelDTO = null;
        do {
        	try {
	            System.out.println("-------------------------------\n"
	            		+ "     Cadastro de Hotéis\n"
	            		+ "-------------------------------\n"
	                    + "1 - Inserir hotel\n"
	                    + "2 - Listar hoteis\n"
	                    + "3 - Atualizar hotel\n"
	                    + "4 - Remover hotel\n"
	                    + "5 - Remover todos hoteis\n"
	                    + "0 - Sair\n"
	                    + "-------------------------------\n"
	                    + "Informe a opção desejada: ");
	            opcao = sc.nextInt();
	            sc.nextLine(); 
	
	            switch (opcao) {
	                case 1:
	                	System.out.println("Informe o nome do hotel:");
	                    nome = sc.nextLine();
	                    System.out.println("Informe o CEP do hotel:");
	                    cep = sc.nextLine();
	                    System.out.println("Informe o logradouro do hotel:");
	                    logradouro = sc.nextLine();
	                    System.out.println("Informe a cidade do hotel:");
	                    cidade = sc.nextLine();
	                    System.out.println("Informe o estado do hotel:");
	                    estado = sc.nextLine();
	                    
	                	hotelDTO = new HotelDTO(null, nome, cep, logradouro, cidade, estado);
	            		service.salvarHotel(hotelDTO);
	            		
	            		System.out.println("Hotel " + nome + " inserido!");
	                    break;
	                    
	                case 2:
	                	List<HotelDTO> hoteis = service.listarHoteis();
	                	hoteis = service.listarHoteis();
	        			for (HotelDTO ho : hoteis) {
	        				System.out.println(ho.toString());
	        			}
	                    break;
	                    
	                case 3:
	                	System.out.println("Codigo do hotel que deseja atualizar: ");
	                	int codigo = sc.nextInt();
	                	sc.nextLine();

	                	Optional<HotelDTO> hotelExistente = service.buscarHotelPorCodigo(codigo);
	                	if (hotelExistente.isPresent()) {
	                	    hotelDTO = hotelExistente.get();

	                	    System.out.println("Informe o novo nome do hotel (ou pressione Enter para manter o atual):");
	                	    nome = sc.nextLine();
	                	    if (!nome.isEmpty()) {
	                	        hotelDTO.setNome(nome);
	                	    }

	                	    System.out.println("Informe o novo cep do hotel (ou pressione Enter para manter o atual):");
	                	    cep = sc.nextLine();
	                	    if (!cep.isEmpty()) {
	                	        hotelDTO.setCep(cep);
	                	    }

	                	    System.out.println("Informe o novo logradouro do hotel (ou pressione Enter para manter o atual):");
	                	    logradouro = sc.nextLine();
	                	    if (!logradouro.isEmpty()) {
	                	        hotelDTO.setLogradouro(logradouro);
	                	    }

	                	    System.out.println("Informe a nova cidade do hotel (ou pressione Enter para manter o atual):");
	                	    cidade = sc.nextLine();
	                	    if (!cidade.isEmpty()) {
	                	        hotelDTO.setCidade(cidade);
	                	    }

	                	    System.out.println("Informe o novo estado do hotel (ou pressione Enter para manter o atual):");
	                	    estado = sc.nextLine();
	                	    if (!estado.isEmpty()) {
	                	        hotelDTO.setEstado(estado);
	                	    }

	                	    service.atualizarHotel(codigo, hotelDTO);
	                	    System.out.println("Hotel atualizado com sucesso!");
	                	} else {
	                	    System.out.println("Hotel com o código " + codigo + " não encontrado.");
	                	}
	                	break;
	                    
	                case 4:
	                	System.out.println("Codigo do hotel que deseja remover: ");
	                	codigo = sc.nextInt();
	                	
	                	service.removerHotel(codigo);
	                    break;
	                    
	                case 5:
	                	service.removerTodos();
	        			System.out.println("Todos hotéis removidos!");
	                    break;
	                    
	                case 0:
	                	System.out.println("Saindo...");
	                    break;
	                    
	                default:
	                    System.out.println("Opção inválida!");
	                    break;
                    
	            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            sc.next();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Erro ao ler a entrada. Tente novamente.");
            if (sc.hasNext()) {
                sc.next();
            }
        }
        } while (opcao != 0);

        sc.close();
    }
}