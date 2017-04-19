package net.luckywings.mobigame.server.logical.response.mobiapi.pay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiCreateOrderJYResponse extends ApiPayCreateOrderResponse{
	private String orderId;

    public ApiCreateOrderJYResponse() {

    }

    public ApiCreateOrderJYResponse(String orderId) {
        super();
        this.orderId = orderId;
    }

}
