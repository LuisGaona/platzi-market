package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.CompraCrudRepository;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository {
	@Autowired
	private CompraCrudRepository compraCrudRepository;
	@Autowired
	private PurchaseMapper mapper;
	
	@Override
	public List<Purchase> getAll() {
		// TODO Auto-generated method stub
		return mapper.toPurchases((List<Compra>)compraCrudRepository.findAll());
	}
	@Override
	public Optional<List<Purchase>> getByClient(String clientId) {
		// TODO Auto-generated method stub
		return compraCrudRepository.findByIdCliente(clientId)
				.map(compras->mapper.toPurchases(compras));
	}
	@Override
	public Purchase save(Purchase purchase) {
		// TODO Auto-generated method stub
		Compra compra=mapper.toCompra(purchase);
		compra.getProductos().forEach(producto->producto.setCompra(compra));
		return mapper.toPurchase(compraCrudRepository.save(compra));
	}

}
