package com.example.cloudproviders.adapters;

import com.example.cloudproviders.libraries.aws.AWSConnectionResponse;
import com.example.cloudproviders.libraries.google.GoogleApi;
import com.example.cloudproviders.libraries.google.GoogleConnectionResponse;
import com.example.cloudproviders.models.Connection;
import com.example.cloudproviders.models.ConnectionStatus;

public class GoogleAdapter implements CloudAdapter{
    @Override
    public Connection createConnection(long userId) {
        GoogleApi api = new GoogleApi();
        GoogleConnectionResponse googleConnectionResponse = api.createConnection(userId);
        Connection connection = new Connection();
        connection.setConnectionId(googleConnectionResponse.getConnectionId());
        connection.setConnectionStatus(ConnectionStatus.valueOf(googleConnectionResponse.getConnectionStatus()));
        connection.setUserId(userId);
        return connection;
    }
}
