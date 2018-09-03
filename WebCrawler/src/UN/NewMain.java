/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UN;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Hewlett Packard
 */
public class NewMain {

    static int count = 0;
    static int i = 0;
    static HashSet<String> All = new HashSet<String>();
    static ArrayList<String> Aldl = new ArrayList<String>(All);

    public static void main(String[] args) {
        names url = new names("https://www.stackoverflow.com");
        check(url);
        System.out.println("Papito " + url.getNurl());
        tellEM(url.getAllNames());
    }

    public static void check(names url) {
        count++;
        i++;
        HashSet<String> lists = new HashSet<String>();

        lists = new webCrawler(url.getNurl(), count).getList();
        count = count - 1 + lists.size();
        tellEMr(lists);
        for (String list : lists) {
            if (!list.equals(url.getNurl()) && isNew(url.getNurl())) {
                names hijo = new names(list);
                url.addName(hijo);
                System.out.println("Hijirillo " + hijo.getNurl());
                System.out.println("this is the father " + list);
                System.out.println(count);
                if (count < 26 && i < 2) {
                    System.out.println(i);
                    check(hijo);
                }
            }
        }
        System.out.println(i);
        if (i >= 1 && i < 2) {
            i++;
        } else {
            i = 1;
        }
    }

    private static boolean isNew(String nurl) {
        if (!Aldl.contains(nurl)) {
            All.add(nurl);
            return true;
        } else {
            return false;
        }
    }

    private static void tellEMr(HashSet<String> lists) {
        System.out.println("They all are: ");
        for (String list : lists) {
            System.out.println(list);
        }
    }

    private static void tellEM(HashSet<names> lists) {
        for (names list : lists) {
            System.out.println(list.getNurl());
        }
//        for (names list : lists) {
//            tellEM(list.getAllNames());
//        }
    }
}
