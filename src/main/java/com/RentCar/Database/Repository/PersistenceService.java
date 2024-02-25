package com.RentCar.Database.Repository;

//Controladora de persistencias, donde se coordinan las operaciones CRUD

import com.RentCar.Database.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersistenceService {
    
    private final ClientesRepo CR;
    
    private final EmpleadosRepo ER;
    
    private final InspeccionRepo IR;
    
    private final MarcasRepo MAR;
    
    private final ModelosRepo MOR;
    
    private final RentaDevolucionRepo RDR;
    
    private final TiposCombustibleRepo TCR;
    
    private final TiposVehiculosRepo TVR;
    
    private final VehiculosRepo VR;

    @Autowired
    public PersistenceService(ClientesRepo CR, EmpleadosRepo ER, InspeccionRepo IR, MarcasRepo MAR, ModelosRepo MOR, RentaDevolucionRepo RDR, TiposCombustibleRepo TCR, TiposVehiculosRepo TVR, VehiculosRepo VR) {
        this.CR = CR;
        this.ER = ER;
        this.IR = IR;
        this.MAR = MAR;
        this.MOR = MOR;
        this.RDR = RDR;
        this.TCR = TCR;
        this.TVR = TVR;
        this.VR = VR;
    }
    
    
    @SuppressWarnings("null")
    public void CrearInspeccion(Inspeccion a){
        
        IR.save(a);        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarInspeccion(Inspeccion a){
        
        Optional<Inspeccion> oa = IR.findById(a.getId());
        
        Inspeccion ab = oa.get();
        
        ab.setVehiculo(a.getVehiculo()); 
        ab.setCliente(a.getCliente());
        ab.setEstado(a.getEstado());
        ab.setTieneRalladuras(a.getTieneRalladuras());
        ab.setCantidadCombustible(a.getCantidadCombustible());
        ab.setFecha(a.getFecha());
        ab.setGomaRespuesta(a.getGomaRespuesta());
        ab.setRoturasCristal(a.getRoturasCristal());
        ab.setTieneGato(a.getTieneGato());
        ab.setVehiculo(a.getVehiculo());
        ab.setDescripcion(a.getDescripcion());
        ab.setGomas(a.getGomas());
        
        IR.save(ab);
    }
        
    
    @SuppressWarnings("null")
    public void ElimInspeccion(Long id){
        
        try {
            IR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<Inspeccion> obtenerInspeccion(){
        
        return IR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<Inspeccion> obtenerInspeccion(Long id){
        
        return IR.findById(id);
    }
    
    
    @SuppressWarnings("null")
    public void CrearCliente(Clientes c){
        
        CR.save(c);
        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarCliente(Clientes c){
        
        Optional<Clientes> oa = CR.findById(c.getId());
        
        Clientes ab = oa.get();
        
        ab.setCedula(c.getCedula());
        ab.setEstado(c.getEstado());
        ab.setLimCredito(c.getLimCredito());
        ab.setNoTargetaCR(c.getNoTargetaCR());
        ab.setNombre(c.getNombre());
        ab.setTipoPersona(c.getTipoPersona());
        
        CR.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void ElimCliente(Long id){
        
        try {
            CR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<Clientes> obtenerCliente(){
        return CR.findAll();
    }
    
    
    
    @SuppressWarnings("null")
    public Optional<Clientes> obtenerCliente(Long id){
        return CR.findById(id);
    }
    
    
    @SuppressWarnings("null")
    public void CrearMarcas(Marcas e){
        
        MAR.save(e);        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarMarcas(Marcas e){
        
        Optional<Marcas> oa = MAR.findById(e.getId());
        
        Marcas ab = oa.get();
        
        ab.setDescripcion(e.getDescripcion());
        ab.setEstado(e.getEstado());
        
        MAR.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void ElimMarcas(Long id){
        
        try {
            MAR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<Marcas> obtenerMarcas(){

        return MAR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<Marcas> obtenerMarcas(Long id){

        return MAR.findById(id);
    }
    
    
    @SuppressWarnings("null")
    public void CrearEmpleado(Empleados em){
        
        ER.save(em);        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarEmpleado(Empleados em){
        
        Optional<Empleados> oa = ER.findById(em.getId());
        
        Empleados ab = oa.get();
        
        ab.setCedula(em.getCedula());
        ab.setEstado(em.getEstado());
        ab.setFechaIngreso(em.getFechaIngreso());
        ab.setNombre(em.getNombre());
        ab.setPorcientoComision(em.getPorcientoComision());
        ab.setTandaLabor(em.getTandaLabor());
        
        ER.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void ElimEmpleado(Long id){
        
        try {
            ER.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<Empleados> obtenerEmpleado(){

        return ER.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<Empleados> obtenerEmpleado(Long id){
        return ER.findById(id);
    }
    
    
    @SuppressWarnings("null")
    public void CrearModelos(Modelos g){
        
        MOR.save(g);
        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarModelos(Modelos g){
        
        Optional<Modelos> oa = MOR.findById(g.getId());
        
        Modelos ab = oa.get();
        
        ab.setDescripcion(g.getDescripcion());
        ab.setEstado(g.getEstado());
        
        MOR.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void ElimModelos(Long id){
        
        try {
            MOR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<Modelos> obtenerModelos(){

        return MOR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<Modelos> obtenerModelos(Long id){

        return MOR.findById(id);
    }
    
    
    
    @SuppressWarnings("null")
    public void CrearTiposCombustible(TiposCombustible i){
        
        TCR.save(i);       
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarTiposCombustible(TiposCombustible i){
        
        Optional<TiposCombustible> oa = TCR.findById(i.getId());
        
        TiposCombustible ab = oa.get();
        
        ab.setDescripcion(i.getDescripcion());
        ab.setEstado(i.getEstado());
        
        TCR.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void ElimTiposCombustible(Long id){
        
        try {
            TCR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<TiposCombustible> obtenerTiposCombustible(){

        return TCR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<TiposCombustible> obtenerTiposCombustible(Long id){
        return TCR.findById(id);
    }
    
    
    @SuppressWarnings("null")
    public void CrearRentaDevolucion(RentaDevolucion rd){
        
        RDR.save(rd);
        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarRentaDevolucion(RentaDevolucion rd){
        
        Optional<RentaDevolucion> oa = RDR.findById(rd.getId());
        
        RentaDevolucion ab = oa.get();
        
        ab.setCantidadDias(rd.getCantidadDias());
        ab.setCliente(rd.getCliente());
        ab.setComentario(rd.getComentario());
        ab.setEmpleado(rd.getEmpleado());
        ab.setEstado(rd.getEstado());
        ab.setFechaDevolucion(rd.getFechaDevolucion());
        ab.setFechaRenta(rd.getFechaRenta());
        ab.setMontoXDia(rd.getMontoXDia());
        
        
        RDR.save(ab);        
    }
        
    
    @SuppressWarnings("null")
    public void ElimRentaDeolucion(Long id){
        
        try {
            RDR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<RentaDevolucion> obtenerRentaDevolucion(){
        
        return RDR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<RentaDevolucion> obtenerRentaDevolucion(Long id){
        
        return RDR.findById(id);
    }
    
    
    @SuppressWarnings("null")
    public void CrearTiposVehiculos(Vehiculos ta){
        
        VR.save(ta);
        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarTiposVehiculos(TiposVehiculos ta){
        
        Optional<TiposVehiculos> oa = TVR.findById(ta.getId());
        
        TiposVehiculos ab = oa.get();
        
        ab.setDescripcion(ta.getDescripcion());
        ab.setEstado(ta.getEstado());
        
        TVR.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void EliTiposmVehiculos(Long id){
        
        try {
            TVR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<TiposVehiculos> obtenerTiposVehiculos(){
        return TVR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<TiposVehiculos> obtenerTiposVehiculos(Long id){
        return TVR.findById(id);
    }
    
    @SuppressWarnings("null")
    public void CrearVehiculos(Vehiculos ta){
        
        VR.save(ta);
        
    }
    
    @SuppressWarnings("null")
    @Transactional
    public void EditarVehiculos(Vehiculos ta){
        
        Optional<Vehiculos> oa = VR.findById(ta.getId());
        
        Vehiculos ab = oa.get();
        
        ab.setDescripcion(ta.getDescripcion());
        ab.setEstado(ta.getEstado());
        
        VR.save(ab);
        
    }
        
    
    @SuppressWarnings("null")
    public void ElimVehiculos(Long id){
        
        try {
            VR.deleteById(id);
        } catch (Exception ex) {
            throw new IllegalStateException("Elemento con id " + id + " no existe exist");
        }        
    }
    
    
    public List<Vehiculos> obtenerVehiculos(){
        return VR.findAll();
    }
    
    
    @SuppressWarnings("null")
    public Optional<Vehiculos> obtenerVehiculos(Long id){
        return VR.findById(id);
    }
    
            
            
}
