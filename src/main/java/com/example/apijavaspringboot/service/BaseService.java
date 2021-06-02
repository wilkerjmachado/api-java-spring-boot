package com.example.apijavaspringboot.service;

import com.example.apijavaspringboot.exception.NotFoundException;
import com.example.apijavaspringboot.exception.ServiceException;
import com.example.apijavaspringboot.model.AbstractEntity;
import com.example.apijavaspringboot.util.ThrowUtil;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public abstract class BaseService<E extends AbstractEntity> {

    @Transactional
    public Page<E> findAll(Pageable pageable){

        return this.getRepository().findAll(pageable);
    }

    @Transactional
    public List<E> findAll(){

        return this.getRepository().findAll();
    }

    @Transactional
    public E findById(Long id){

        return this.getRepository().findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<E> find(E entity){

        return this.getRepository().findAll(Example.of(entity));
    }

    @Transactional
    public E save(E entity) {

        this.validate(entity);

        try {

            return this.getRepository().save(entity);

        } catch (Exception e) {

            throw new ServiceException("Erro ao salvar registro! ${e.message}");
        }
    }

    @Transactional
    public void excluir(Long id) {

        this.validateDelete(this.getRepository().getById(id));

        this.getRepository().deleteById(id);
    }

    protected void validateDelete(E entity) {

        ThrowUtil.serviceExceptionThrow(Objects.isNull(entity), "Nenhum dado enviado!");
    }

    protected void validate(E entity) {

        ThrowUtil.serviceExceptionThrow(Objects.isNull(entity), "Nenhum dado enviado!");
    }

    protected abstract JpaRepository<E, Long> getRepository();

}