package jp.co.regal.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.regal.dto.test.AddressDto;
import jp.co.regal.dto.test.TestDto;
import jp.co.regal.entity.Address;
import jp.co.regal.entity.Test;
import jp.co.regal.mapper.TestMapper;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;
/*    選ばれた住所に対して、マッパーからメソッドを呼び出して（エンティティ
    に格納された状態で）取得、Dtoにつめなおす。*/
    public TestDto getTest(Integer id) {
        TestDto dto = new TestDto();
        Test entity = testMapper.getTest(id);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<AddressDto> getAddress(){
    	List<Address> addressList = testMapper.getAddress();
    	List<AddressDto> resultList = convertToDto(addressList);
    	return resultList;
    }

    private List<AddressDto> convertToDto(List<Address> addressList){
    	List<AddressDto> resultList= new LinkedList<AddressDto>();
    	for(Address entity : addressList){
    		AddressDto dto = new AddressDto();
    		BeanUtils.copyProperties(entity, dto);
    		resultList.add(dto);
    	}


    	return resultList;
    }


    public Map<Integer,String> getAddressMap(){
    	List<Address> getAddressMap = testMapper.getAddress();
    	Map<Integer,String> slectAddressMap = convertToMap(getAddressMap);
    	return slectAddressMap;

    }

    private Map<Integer,String> convertToMap(List<Address> addressList){
    	Map<Integer,String> selectBoxAddress = new HashMap<Integer,String>();
    	for(Address entity : addressList){
    		 selectBoxAddress.put(entity.getId(),entity.getAddress());
    	}


    	return selectBoxAddress;
    }

}