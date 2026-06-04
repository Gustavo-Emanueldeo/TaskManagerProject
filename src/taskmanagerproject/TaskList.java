/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagerproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo E
 */
public class TaskList<T> {
    private List<T> list = new ArrayList<T>();
    
    public void insertElement(T element){
        list.add(element);
    }
    
    public void removeElement(T element){
        list.remove(element);
    }
    
    public List<T> getList(){
        return this.list;
    }
}
