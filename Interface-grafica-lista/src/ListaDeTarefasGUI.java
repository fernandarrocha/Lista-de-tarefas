import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ListaDeTarefasGUI extends JFrame {
    private ArrayList<String> tarefas;
    private JPanel painel;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnListar;
    private JTextArea txtTarefas;

    public ListaDeTarefasGUI() {
        tarefas = new ArrayList<String>();
        painel = new JPanel();
        btnAdicionar = new JButton("Adicionar tarefa");
        btnRemover = new JButton("Remover tarefa");
        btnListar = new JButton("Listar tarefas");
        txtTarefas = new JTextArea(10, 30);

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tarefa = JOptionPane.showInputDialog("Digite a tarefa a ser adicionada:");
                adicionarTarefa(tarefa);
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int indice = Integer.parseInt(JOptionPane.showInputDialog("Digite o índice da tarefa a ser removida:"));
                removerTarefa(indice);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarTarefas();
            }
        });

        painel.add(btnAdicionar);
        painel.add(btnRemover);
        painel.add(btnListar);
        painel.add(new JScrollPane(txtTarefas));

        add(painel);

        setTitle("Aplicativo de Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void adicionarTarefa(String tarefa) {
        tarefas.add(tarefa);
        JOptionPane.showMessageDialog(this, "Tarefa adicionada com sucesso.");
    }

    private void removerTarefa(int indice) {

        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            JOptionPane.showMessageDialog(this, "Tarefa removida com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Índice inválido.");
        }
    }

    private void listarTarefas() {
        StringBuilder sb = new StringBuilder();
        for (String tarefa : tarefas) {
            sb.append(tarefa).append("\n");
        }
        txtTarefas.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListaDeTarefasGUI();
            }
        });
    }
}