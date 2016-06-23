package com.joker.wms.dao.hibernate;

import com.joker.wms.model.ShipCar;
import com.joker.wms.dao.ShipCarDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("shipCarDao")
public class ShipCarDaoHibernate extends GenericDaoHibernate<ShipCar, Long> implements ShipCarDao {

    public ShipCarDaoHibernate() {
        super(ShipCar.class);
    }
}
