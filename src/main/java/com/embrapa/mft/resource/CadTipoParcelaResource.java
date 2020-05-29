package com.embrapa.mft.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embrapa.mft.repository.CadTipoParcelaRepository;

@RestController
@RequestMapping("/cadtipoparcela")
public class CadTipoParcelaResource {

	@Autowired
	private CadTipoParcelaRepository cadTipoParcelaRepository;
}
