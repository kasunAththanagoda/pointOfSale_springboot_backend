package com.pos.pointOfSale.service.impl;

import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.QueryInterfaces.OrderDetailInterface;
import com.pos.pointOfSale.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.pos.pointOfSale.dto.request.RequestOrderSaveDto;
import com.pos.pointOfSale.dto.response.ResponseOrderDetailsDto;
import com.pos.pointOfSale.entity.Customer;
import com.pos.pointOfSale.entity.Order;
import com.pos.pointOfSale.entity.OrderDetails;
import com.pos.pointOfSale.repository.CustomerRepo;
import com.pos.pointOfSale.repository.ItemRepo;
import com.pos.pointOfSale.repository.OrderDetailsRepo;
import com.pos.pointOfSale.repository.OrderRepo;
import com.pos.pointOfSale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional //mthn table ekkt wada wadi gankt data dnwa.ekt hri dnkot awlk gyth okkma ahpw roll back wnna one
    public String addOrder(RequestOrderSaveDto requestOrderSaveDto) {

        //oder table ekti order details table ekti fktm save krnna one
        //order entity ekt ona data
        //Customer customer, Set<OrderDetails> orderDetails, int orderId, Date date, double total
        //mtnin orderid eka auto generate wna ekk nsa eka ntwa alutn constructor ekk hdnw order eke
        //orderdetails ywnnth na.ekthn ntw constructor ek hdnna
        // Customer customer, Date date, double total
        // customer ge object ekk ilanne.apit dto eke tynne id eka.id eka use krla api customer object ekk gnwa.eka gnna autowire krla customerRepo eka gnna

        Order order = new Order(
                customerRepo.getById(requestOrderSaveDto.getCustomer()),
                requestOrderSaveDto.getDate(),
                requestOrderSaveDto.getTotal()
        );
        orderRepo.save(order); //order table ekt data dmma

        //ilgta order details ekt data tka dnna one
        if(orderRepo.existsById(order.getOrderId())){
//            //apu dto eke tyna orderdetails tka argena orderdetails entity ekt da gnna wnwa.ekt foreach ekk hri model mapper ekk hri use krnna wnwa

            List<OrderDetails> orderDetails = modelMapper
                    .map(requestOrderSaveDto.getOrderDetails(), new TypeToken<List<OrderDetails>>() {
                    }.getType());
            //mthnin anik data tka awta order id eka enne na.ae nsa eka wnma set kara gnna wnwa
            //dto eke enne itemid eka a unt api ywnna one ite object ekk .ekthset kra gnna one //ekt item repo ek ona wna nsa.eka autowire kra gnna
            for (int i=0;i<orderDetails.size();i++){
               orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDto.getOrderDetails().get(i).getItems()));
            }

            if(orderDetails.size()>0){
//                //dn api orderDetails table ekt dnna ynne.eka krnna ona nwa orderDetailsRepo eka autowire krgnna
//                //ekin eka save krnne ntwa list eke okkma eka para dnna method ekk tynwa
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "order saved";
        }
        return null;

    }


    @Override
    public PaginatedResponseOrderDetailsDto getAllOrdersFiltred(boolean state, int page, int size) {
        // api wna wlwta orderrepo eka hrhaa query ek run krwl ekn ena data ekko void nttn entity ekt da gnnwa.but me wlwe join query ekk nsa
        //table dkka data enwa.ae tka alla gnna interface ekk hda gnna wnwa //ae interface eket danne type methods wdhta

        List<OrderDetailInterface> orderDetailInterfaces=orderRepo.getAllOrderDetails(state, PageRequest.of(page,size));

        //api elyt dnna one dto type ekn.ae nsa mka dto wlt convert kra gnna one

        //apita ona typekn list ekk hdagtta
        List<ResponseOrderDetailsDto> responseOrderDetailsDtoList=new ArrayList<>();
        //foreach ekkin ekin ekta danna ynne.ona nan map krnnath plwn
        for(OrderDetailInterface i : orderDetailInterfaces){
            ResponseOrderDetailsDto responseOrderDetailsDto= new ResponseOrderDetailsDto(
                    i.getCustomerName(),
                    i.getCustomerAddress(),
                    i.getContactNumber(),
                    i.getDate(),
                    i.getTotal()
            );

//            String customerName, String customerAddress, ArrayList contactNumber, Date date, double total
        responseOrderDetailsDtoList.add(responseOrderDetailsDto);
        }

        //ilta api elyt dnna one paginate krla nsa api ae object ekt da gnna one
        PaginatedResponseOrderDetailsDto paginatedResponseOrderDetailsDto=new PaginatedResponseOrderDetailsDto(
                responseOrderDetailsDtoList,
                orderRepo.countOrderDetails(state)
        );

//        if(orderDetailInterfaces.size()>0){System.out.println(orderDetailInterfaces.get(0).getCustomerName());}
//        else{
//            System.out.println("empty");
//        }


        return paginatedResponseOrderDetailsDto;
    }
}
