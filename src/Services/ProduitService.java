/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
import Entities.Regime;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class ProduitService {
    
      public ArrayList<Produit> getList2() {
        ArrayList<Produit> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8080/PIDEV-one-to-many/web/app_dev.php/mobile/affProduit");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" +tasks.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {
                        Produit task = new Produit();
                        float id = Float.parseFloat(obj.get("id").toString());
                        task.setId((int) id);
                        task.setNom(obj.get("nom").toString());
                        task.setPrix(Double.parseDouble(obj.get("prix").toString()));
                         task.setImage_produit(obj.get("imageProduit").toString());
                        listTasks.add(task);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
      
      
     
    
}
