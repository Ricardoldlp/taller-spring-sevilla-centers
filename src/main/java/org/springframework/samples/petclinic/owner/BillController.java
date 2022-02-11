package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BillController {
	private static final String VIEWS_BILL_CREATE_OR_UPDATE_FORM = "facturas/createOrUpdateBillForm";
    //private final BillRepository facturas;
    
	@Autowired
    private BillService billService;
    @Autowired
    private OwnerService ownerService;
	
	@RequestMapping(value="/facturas/view/{id}",method = RequestMethod.GET)
	public String findById(@PathVariable("id")Integer id) {
		Bill bill = billService.findById(id);
		return "Factura: "+bill.getIdNumber()+". Fecha: "+bill.getPaymentDate()+". Coste: "+bill.getMoney();
	}
	
	@RequestMapping(value="/facturas/save", method = RequestMethod.POST)
	public String save(@RequestBody Bill bill) {
		try {
			Owner cliente = ownerService.findById(bill.getCliente().getId());
			bill.setCliente(cliente);
			billService.save(bill);
			return "Correcto";
		}catch(Exception e) {
			return "Peta";
		}
	}
	
	@RequestMapping(value="/facturas/delete/{id}",method= RequestMethod.DELETE)
	public void delete(@PathVariable("id")Integer id) {
		billService.delete(id);
	}
	
	@RequestMapping(value="/facturas/edit", method = RequestMethod.PUT)
	public String edit(@RequestBody Bill bill) {
		try {
			Owner cliente = ownerService.findById(bill.getCliente().getId());
			bill.setCliente(cliente);
			billService.save(bill);
			return "Correcto";
		}catch(Exception e) {
			return "Peta";
		}
	}
	
}
