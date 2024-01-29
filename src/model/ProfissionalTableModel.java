
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProfissionalTableModel extends AbstractTableModel {

    private List<Profissional> dados = new ArrayList<>();
    private String[] colunas = {"CRMV", "Nome", "Especialidade", "Horário"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getCrmv();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getEspecialidade();
            case 3:
                return dados.get(linha).getHorario();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linha).setCrmv((String) valor);
                break;
            case 1:
                dados.get(linha).setNome((String) valor);
                break;
            case 2:
                dados.get(linha).setEspecialidade((String) valor);
                break;
            case 3:
                dados.get(linha).setHorario((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    
    
    public void addRow (Profissional p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow (int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    
    
}
