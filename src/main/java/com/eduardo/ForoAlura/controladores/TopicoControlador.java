package com.eduardo.ForoAlura.controladores;

import com.eduardo.ForoAlura.entidad.curso.Curso;
import com.eduardo.ForoAlura.entidad.topico.Topico;
import com.eduardo.ForoAlura.entidad.topico.TopicoEnvioDatos;
import com.eduardo.ForoAlura.entidad.topico.TopicoListar;
import com.eduardo.ForoAlura.entidad.topico.TopicoRespuestaDatos;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import com.eduardo.ForoAlura.errores.ResourceNotFoundException;
import com.eduardo.ForoAlura.repositorio.CursoRepositorio;
import com.eduardo.ForoAlura.repositorio.TopicoRepositorio;
import com.eduardo.ForoAlura.repositorio.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/topicos")
public class TopicoControlador {

    @Autowired
    private TopicoRepositorio topicoRepository;

    @Autowired
    private CursoRepositorio cursoRepository;

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @PostMapping
    public ResponseEntity<TopicoRespuestaDatos> crearTopico(@Valid @RequestBody TopicoEnvioDatos topicoEnvioDatos) {

        Curso curso = cursoRepository.findByNombre(topicoEnvioDatos.nombre())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
        Usuario autor = usuarioRepository.findById(topicoEnvioDatos.id())
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));


        Topico topico = new Topico();
        topico.setTitulo(topicoEnvioDatos.titulo());
        topico.setMensaje(topicoEnvioDatos.mensaje());
        topico.setCurso(curso);
        topico.setAutor(autor);
        topico.setCreacion(LocalDateTime.now());
        topico.setStatus(true);

        topicoRepository.save(topico);

        TopicoRespuestaDatos respuesta = new TopicoRespuestaDatos(
                topico.getId(),
                topico.getMensaje(),
                topico.getTitulo(),
                topico.getCreacion()
        );


        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }


    @GetMapping
    public ResponseEntity<Page<TopicoListar>> listarTopico(@PageableDefault(size = 9) Pageable paginacion) {
        Page<TopicoListar> topicos = topicoRepository.findByStatusTrue(paginacion).map(TopicoListar::new);
        return ResponseEntity.ok(topicos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid TopicoRespuestaDatos topicoRespuesta) {
        Topico topicoActualizar = topicoRepository.getReferenceById(topicoRespuesta.id());
        topicoActualizar.actualizarDatosTopico(topicoRespuesta);
        return ResponseEntity.ok(new TopicoRespuestaDatos(
                topicoActualizar.getId(),
                topicoActualizar.getMensaje(),
                topicoActualizar.getTitulo(),
                topicoActualizar.getCreacion()
                ));

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

}
