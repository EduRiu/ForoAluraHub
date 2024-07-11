package com.eduardo.ForoAlura.servicio;

import com.eduardo.ForoAlura.entidad.curso.Curso;
import com.eduardo.ForoAlura.entidad.topico.Topico;
import com.eduardo.ForoAlura.entidad.topico.TopicoEnvioDatos;
import com.eduardo.ForoAlura.entidad.topico.TopicoRespuestaDatos;
import com.eduardo.ForoAlura.errores.ValidacionDeIntegridad;
import com.eduardo.ForoAlura.repositorio.CursoRepositorio;
import com.eduardo.ForoAlura.repositorio.TopicoRepositorio;
import com.eduardo.ForoAlura.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CrearTopicoServicio {

    /*@Autowired
    private CursoRepositorio cursoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private TopicoRepositorio topicoRepositorio;


    public TopicoRespuestaDatos crearTopico(TopicoEnvioDatos datos) {

        if (!cursoRepositorio.findById(datos.curso().getId()).isPresent()) {
            throw new ValidacionDeIntegridad("curso no encontrado");
        }

        if (datos.autor() != null && !usuarioRepositorio.existsById(datos.autor().getId())) {
            throw new ValidacionDeIntegridad("autor no encontrado");
        }


       Long numeroCurso = cursoRepositorio.findIdByNombre(datos.curso());

        Optional<Curso> curso = cursoRepositorio.findById(numeroCurso);


        var autor = usuarioRepositorio.findById(datos.autor().getId());

        var topicoCreado = new Topico(
                autor,
                datos.mensaje(),
                curso,
                datos.titulo());

        topicoRepositorio.save(topicoCreado);

        return new TopicoRespuestaDatos(null, datos.titulo(), datos.mensaje(), LocalDateTime.now());

    }
*/
}