/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.uas.praktik;

import latihan.uas.praktik.exceptions.NonexistentEntityException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ABID
 */
@Controller
@ResponseBody
public class BarangController {
    Barang data = new Barang ();
    BarangJpaController control = new BarangJpaController();
    
    @RequestMapping ("/getNama/{id}")
    public String getNama(@PathVariable("id") int id){
        try{
            data = control.findBarang(id);
            return data.getNama();
        }catch(Exception errror){
            return "Data tidak ada !!";
        }
    }
    @RequestMapping ("/edit/{id}")
    public String update(@PathVariable("id") int id){
        try{
            control.edit(data);
            return data.getNama();
        }catch(Exception errror){
            return "Data tidak ada !!";
        }
    }
    @RequestMapping ("/create/{id}")
    public String post(@PathVariable("id") int id){
        try{
            control.create(data);
            return data.getNama();
        }catch(Exception errror){
            return "Data tidak ada !!";
        }
    }
    @RequestMapping ("/delete/{id}")
    public String deleteData(@PathVariable("id") int id){
        try{
            control.destroy(id);
            return id+"deleted";
        }catch(NonexistentEntityException errror){
            return id + "tidak ada !!";
        }
    }
}
