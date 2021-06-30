package com.desafio.web.rest;

import com.desafio.service.DmViewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dmview")
public class DmViewResource {

    private final DmViewService dmViewService;

    public DmViewResource(DmViewService dmViewService) {
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
        return ResponseEntity.ok(dmViewService.verificarFeatureSuportada(feature));
    }

}
