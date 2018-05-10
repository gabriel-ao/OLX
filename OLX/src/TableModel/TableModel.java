/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Classes.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thais
 */
public class TableModel extends AbstractTableModel{
    private List<Produto> dados;
    private String[] colunas = {"Nome", "Bairro","Cidade","UF"};
    
    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }
    
    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }        
        //dados.size retorna o tamanho da lista
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
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getBairro();
            case 2:
                return dados.get(linha).getCidade();
            case 3:
                return dados.get(linha).getUF();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }
    
    public Produto getRowValue(int l) {
        return dados.get(l);
    }
    
    public void setDados(List<Produto> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

}
