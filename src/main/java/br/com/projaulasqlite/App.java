package br.com.projaulasqlite;

import br.com.projaulasqlite.Model.Agenda;
import br.com.projaulasqlite.Repository.AgendaDB;

public class App {

    private static void inserir(){
        Agenda a = new Agenda();
        a.setNome("João da Silva");
        a.setTelefone("16 9 34567654");
        AgendaDB db = new AgendaDB();
        db.inserir(a);
    }

    private static void update(){
        Agenda a = new Agenda();
        a.setNome("André Luiz da Silva");
        a.setTelefone("16 9 88887777");
        a.setId(1002);
        AgendaDB db = new AgendaDB();
        db.update(a);
    }

    private static void delete(){
        AgendaDB db = new AgendaDB();
        db.delete(1003);
    }

    private static void findAll(){
        AgendaDB db = new AgendaDB();
        for (Agenda a: db.finalAll()) {
            System.out.println("Id: " + a.getId());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Telefone: " + a.getTelefone());
            System.out.println("********************************");
        }
    }

    public static void main(String[] args) {
        System.out.println("INICIO...");
        //inserir();
        //update();
        //delete();
        findAll();
        System.out.println("FIM");
    }


}
