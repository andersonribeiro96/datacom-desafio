package com.desafio.web.rest;

import com.desafio.service.DmViewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dmview")
public class DmviewResource {

    @Autowired
    private final DmViewService dmViewService;

    public DmviewResource(DmViewService dmViewService) {
        this.dmViewService = dmViewService;
    }

    @GetMapping(value = "/versao")
    @ApiOperation(value = "Informa a versão do software")
    public ResponseEntity<String> obterVersao(){
        return ResponseEntity.ok(dmViewService.obterVersao());
    }

    @GetMapping(value = "/nome")
    @ApiOperation(value = "Informa o nome do produto")
    public ResponseEntity<String> obterNome(){
        return ResponseEntity.ok(dmViewService.obterNome());
    }

    @GetMapping(value = "/feature/{feature}")
    @ApiOperation(value = "Verifica se determinada feature é suportada")
    public ResponseEntity<String> featureSuportada(@PathVariable String feature){
        dmViewService.verificarFeatureSuportada(feature);
        return ResponseEntity.ok("Feature suportada");
    }

}
