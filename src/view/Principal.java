package view;

import java.util.Scanner;

import controller.SO;

public class Principal {

	public static void main(String[] args) {
		SO procController = new SO();
		String os = procController.os();
		System.out.println(os);
		Scanner ler = new Scanner(System.in);
		String process = procController.osTask(os);		
		System.out.println("Deseja visializar as tarefas? s/n");
		String vis = ler.nextLine();
		char visi = vis.charAt(0);
		if(visi == 's') {
		procController.readProcess(process, os);
		System.out.println("Deseja eliminar alguma tarefa? \n s/n");
		String n = ler.nextLine();
		char na = n.charAt(0);
		if(na == 's') {
			System.out.println("Deseja eliminar qual tarefa? ");
			String rec = ler.nextLine();
			procController.killProcess(rec, os);
			procController.readProcess(process, os);
			System.out.println("Processo feito com sucesso");
			System.exit(0);
		}else {
			System.out.println("Tchau!!");
			System.exit(0);
		}
	}else{
		System.out.println("Tchau!!");
		System.exit(0);
	}}

}
