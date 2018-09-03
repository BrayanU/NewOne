/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UN;

import java.util.HashSet;

/**
 *
 * @author Hewlett Packard
 */
public class names {

    private HashSet<names> name = new HashSet<names>();
    private String Nurl;

    public names(String url) {
        Nurl = url;
    }

    public HashSet<names> getAllNames() {
        return name;
    }

    public String getNurl() {
        return Nurl;
    }

    public void addName(names newname) {
        this.name.add(newname);
    }

}
