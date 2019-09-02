package com.segware.bean;

import java.util.ArrayList;
import java.util.List;

public class Posteds 
{
    private List<Posted> postedList;
    
    public List<Posted> getPostedList() {
        if(postedList == null) {
        	postedList = new ArrayList<>();
        }
        return postedList;
    }
 
    public void setPostedList(List<Posted> postedList) {
        this.postedList = postedList;
    }
}
