package edu.ping.stockx.domain.criteria;

import java.util.List;

import edu.ping.stockx.domain.Offer;

public class Max implements Criteria {
    
    private Criteria criteria;
    private Criteria otheCriteria;

    public Max(Criteria criteria, Criteria otheCriteria) {
        this.criteria = criteria;
        this.otheCriteria = otheCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item) {
        // TODO Auto-generated method stub
        return null;
    }

    


}