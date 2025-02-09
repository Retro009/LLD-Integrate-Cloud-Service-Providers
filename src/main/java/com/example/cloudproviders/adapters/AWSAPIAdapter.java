package com.example.cloudproviders.adapters;

import com.example.cloudproviders.libraries.aws.AWSApi;
import com.example.cloudproviders.libraries.aws.AWSConnectionResponse;
import com.example.cloudproviders.models.Connection;
import com.example.cloudproviders.models.ConnectionStatus;

public class AWSAPIAdapter implements CloudAdapter{
    private AWSApi api;
    public AWSAPIAdapter(){
        api = new AWSApi();
    }
    @Override
    public Connection createConnection(long userId) {

        AWSConnectionResponse awsConnectionResponse = api.createConnection(userId);
        Connection connection = new Connection();
        connection.setConnectionId(awsConnectionResponse.getConnectionId());
        connection.setConnectionStatus(ConnectionStatus.valueOf(awsConnectionResponse.getConnectionStatus()));
        connection.setUserId(userId);
        return connection;
    }
}
