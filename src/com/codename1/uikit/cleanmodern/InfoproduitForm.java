/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import Entities.Produit;
import Services.ProduitService;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.CheckBox;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class InfoproduitForm extends BaseForm  {
     EncodedImage enc;
     
     public InfoproduitForm(Resources res){ 
         
         
        setTitle("Information du produit");
        getContentPane().setScrollVisible(false);
        
        Image img = res.getImage("");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Label facebook = new Label("786 followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label("486 followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            facebook,
                            FlowLayout.encloseCenter(
                                new Label(res.getImage("profile-pic.jpg"), "PictureWhiteBackgrond")),
                            twitter
                    )
                )
        ));
        
        ProduitService prod = new ProduitService();
        
        
          
         try {
             enc = EncodedImage.create("/giphy.gif");
         } catch (IOException ex) {
            
         }
          
                //Image image = URLImage.createToStorage(enc, P.getImage_produit(), "http://localhost:8080/PIDEV-one-to-many/web/imagesPidev/" + P.getImage_produit());
                
 

        TextField username = new TextField("sandeep");
        username.setUIID("TextFieldBlack");
        //addStringValue();

        TextField email = new TextField("sandeep@gmail.com", "E-Mail", 20, TextField.EMAILADDR);
        email.setUIID("TextFieldBlack");
        //addStringValue("E-Mail", email);
        
        TextField password = new TextField("sandeep", "Password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        //addStringValue("Password", password);

       
        
     }
    
}
