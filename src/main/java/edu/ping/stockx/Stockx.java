package edu.ping.stockx;

import java.util.List;

import edu.ping.stockx.domain.criteria.Asks;
import edu.ping.stockx.domain.criteria.Bids;
import edu.ping.stockx.domain.criteria.Criteria;
import edu.ping.stockx.domain.criteria.MaxBid;
import edu.ping.stockx.domain.criteria.MinAsk;
import edu.ping.stockx.domain.item.Item;
import edu.ping.stockx.domain.item.Sneaker;
import edu.ping.stockx.domain.offer.Ask;
import edu.ping.stockx.domain.offer.Bid;
import edu.ping.stockx.domain.offer.Offer;

/**
 * StockX nació en Detroit, y allí siguen haciendo las cosas a la manera
 * tradicional, robustas y con alma, en ASCII en la CLI.
 * 
 * Implementa las historias de usuario de las GUI proporcionadas, pero en ASCII.
 * 
 * La lógica tras cada historia de usuario está descrita en el `main` de la
 * clase principal `Stockx.java`.
 * 
 * Si tienes dudas, puedes interactuar con la webapp based in London que sí que
 * tiene (G)UI https://stockx.com/air-jordan-1-retro-high-dark-mocha
 */


public class Stockx {

    public static void main(String[] args) {

        /**
         * Crear la zapatilla
         * y printar sus datos.
         *
         * Lee la funcion draw() del main
         * para conocer que propiedades
         * de la zapatilla han de printarse.
         */

        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(Stockx.draw(sneaker));

        /**
         * Crear bids
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));

        /**
         * Crear asks
         * y añadirlas a la zapatilla
         * en sus offers.
         */

        Ask ask = new Ask("13", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));

        /**
         * Crear el filtro "Bids" que filtra
         * solo las bids de entre las
         * offers de la zapatilla.
         */

        Criteria bids = new Bids();
        System.out.println("\n\t\t All BIDS");
        bids.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Crea el filtro "Asks" que filtra
         * solo las asks de entre las
         * offers de la zapatilla.
         */
        
        Criteria asks = new Asks();
        System.out.println("\n\t\t All ASKS");
        asks.checkCriteria(sneaker).forEach(System.out::print);

        /**
         * Muestra la bid maxima
         * de la zapatilla. 
         * 
         * Crea el filtro MaxBid que filtra
         * el maximo de las bids de la zapatilla.
         * Devuelve la bid maxima como unico
         * elemento de una lista de offers.
         * 
         * Guarda esta bid maxima en la
         * propiedad bid de sneaker.
         */

        Criteria maxBid = new MaxBid();
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        sneaker.setBid(maximum.isEmpty()? 0 : maximum.get(0).value());
        System.out.println(Stockx.draw(sneaker));

        /**
         * Muestra la ask minima
         * de la zapatilla. 
         * 
         * Crea el filtro MinAsk que filtra
         * el minimo de las asks de la zapatilla.
         * Devuelve la ask minima como unico
         * elemento de una lista de offers.
         * 
         * Guarda esta ask minima en la propiedad
         * ask de sneaker.
         */

        Criteria minAsk = new MinAsk();
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        sneaker.setAsk(minimum.isEmpty()? 0 : minimum.get(0).value());
        System.out.println(Stockx.draw(sneaker));
    }

    public static String draw(Item sneaker) {
        return
        "\n\n\t\t" + sneaker.getAsk() + " Buy\t" 
        + sneaker.getBid() + " Sell \n" +  

        "\t\t" + " _    _" + "\n" +
        "\t\t" + "(_\\__/(,_" + "\n" +
        "\t\t" + "| \\ `_////-._" + "\n" +
        "\t\t" + "J_/___\"=> __/`\\" + "\n" +
        "\t\t" + "|=====;__/___./" + "\n" +
        "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
        
        "\t" + sneaker.toString() + "\n" +
        "\t\tlast sale: " + sneaker.getSale();
    }
}
