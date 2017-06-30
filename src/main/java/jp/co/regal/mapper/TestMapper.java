package jp.co.regal.mapper;

import java.util.List;

import jp.co.regal.entity.Address;
import jp.co.regal.entity.Test;

public interface TestMapper {
 Test getTest(int id);
 List<Address> getAddress();
}
