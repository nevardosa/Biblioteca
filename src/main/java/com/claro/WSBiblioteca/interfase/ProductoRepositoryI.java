package com.claro.WSBiblioteca.interfase;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.claro.WSBiblioteca.dto.ProductoDTO;
import com.claro.WSBiblioteca.model.entity.Categoria;
import com.claro.WSBiblioteca.model.entity.Producto;

@Repository
@Transactional() 
public interface ProductoRepositoryI extends JpaRepository<Producto, Integer> {

		//@Query(value = "SELECT p.fechaInactivacion, p.cantidadEjemplares, p.idProducto, p.maxPeriodo, p.idCategoria, p.titulo, p.fechaLlegada, p.cantidadEjemplares, p.tipo, c.nombreCategoria, a.idAutor from producto p, autor a, categoria c  ;", nativeQuery = true)
		public List <ProductoDTO> consultarProducto(String idCategoria, String idAutor, int estado, String titulo, String fechaLlegada, String maxPeriodo);

		//@Query(value = "SELECT idCategoria, nombreCategoria from categoria;", nativeQuery = true)
		public Categoria consultarProductoCategoria(String idCategoria );

		//@Query(value = "SELECT p.tipo, p.fechaInactivacion, p.cantidadEjemplares, p.idProducto, p.maxPeriodo, p.idCategoria, p.titulo, p.fechaLlegada, p.cantidadEjemplares from producto p ", nativeQuery = true)
		public Producto actualizarProducto(Date fechaInactivacion,  String cantidadEjemplares, String maxPeriodo, int estado);		

/*
	@Query(value = "SELECT mec.tipo_documento, mec.documento, mec.primer_nombre, mec.segundo_nombre, mec.primer_apellido, mec.segundo_apellido,mec.celular, mec.direccion, mec.email, mec.estado, (SELECT IFNULL(SUM(ser.tiempo_estimado), 0) FROM carcare.servicios_x_mantenimientos AS ser WHERE ser.cod_mantenimiento = man.codigo  AND man.fecha < DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS horas FROM carcare.mecanicos AS mec LEFT JOIN carcare.mantenimientos AS man ON mec.tipo_documento = man.mec_tipo_documento AND mec.documento = man.mec_documento WHERE mec.estado = 'a' ORDER BY horas DESC LIMIT 10;" , nativeQuery = true)
	public List<ProductoDTO> consultarProducto();

//	@Procedure("sp_crear_mecanico")
	@Query(value = "call sp_crear_mecanico(:in_tipo_documento,:in_documento,:in_primer_nombre,:in_segundo_nombre,:in_primer_apellido,:in_segundo_apellido,:in_celular,:in_direccion,:in_email,:in_estado)", nativeQuery = true)
	@Modifying
	void insertMecanico(@Param("in_tipo_documento") String in_tipo_documento, @Param("in_documento") int in_documento,
			@Param("in_primer_nombre") String in_primer_nombre, @Param("in_segundo_nombre") String in_segundo_nombre,
			@Param("in_primer_apellido") String in_primer_apellido,
			@Param("in_segundo_apellido") String in_segundo_apellido, @Param("in_celular") String in_celular,
			@Param("in_direccion") String in_direccion, @Param("in_email") String in_email,
			@Param("in_estado") String in_estado) throws InvalidDataAccessApiUsageException;

	 Mecanicos findByName(String string);*/
}
