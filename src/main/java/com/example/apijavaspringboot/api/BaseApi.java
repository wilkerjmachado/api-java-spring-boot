package com.example.apijavaspringboot.api;

import com.example.apijavaspringboot.model.AbstractEntity;
import com.example.apijavaspringboot.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseApi<E extends AbstractEntity, S extends BaseService<E>> {

    protected abstract S getService();

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<E> save(@Valid @RequestBody E entidade) {

        return ResponseEntity.ok(this.getService().save(entidade));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, value = "")
    public ResponseEntity<E> update(@Valid @RequestBody E entidade) {

        return ResponseEntity.ok(this.getService().save(entidade));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        this.getService().excluir(id);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/pageable", params = { "page", "size" })
    public ResponseEntity<Page<E>> findPageable(@RequestParam("page") int page, @RequestParam("size") int size) {

        return ResponseEntity.ok(this.getService().findAll(PageRequest.of(page, size)));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<List<E>> findAll() {

        return ResponseEntity.ok(this.getService().findAll());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<E> findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(this.getService().findById(id));

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/find")
    public ResponseEntity<List<E>> find(@RequestBody E example) {

        return ResponseEntity.ok(this.getService().find(example));
    }
}
