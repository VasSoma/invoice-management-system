import axios from 'axios';

const apiClient = axios.create({
    headers: {
        'baseUrl': 'http://localhost:8080',
        'Content-Type': 'application/json',
    },
});

//User requests--------------------------------------------------------------------

export const loginUser = (credentials) => {
    const { username, password } = credentials;
  
    return axios.post(`/auth/login`, {}, {
      auth: {
        username,
        password,
      },
    });
};

export const logoutUser = () => {
    try {
        const response = apiClient.post('/auth/logout');
        return response.data;
    } catch (error) {
        console.error('Error logging out:', error)
        throw error;
    }
};

export const fetchCurrentUsers = async () => {
    try {
        const response = await apiClient.get('/users/current-user');
        return response.data;
    } catch (error) {
        console.error('Error fetching current user:', error);
        throw error;
    }
};

export const fetchUsers = async () => {
    try {
        const response = await apiClient.get('/users/getAllUsers');
        return response.data;
    } catch (error) {
        console.error('Error fetching users:', error);
        throw error;
    }
};

export const fetchUser = async (userId) => {
    try {
        const response = await apiClient.get(`/users/${userId}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching user with id: ' + userId, error);
        throw error;
    }
};

export const removeUser = async (userId) => {
    try {
        const response = await apiClient.delete(`/users/${userId}`);
        return response.data;
    } catch (error) {
        console.error('Error deleting user with id:' + userId, error);
        throw error;
    }
};

export const createUser = async (userData) => {
    try {
        const response = await apiClient.post('/users', userData);
        return response.data;
    } catch (error) {
        console.error('Error creating user:', error);
        throw error;
    }
};

//Invoice requests--------------------------------------------------------------------

export const fetchInvoice = async (invoiceId) => {
    try {
        const response = await apiClient.get(`/invoices/${invoiceId}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching invoice with id: ' + invoiceId, error);
        throw error;
    }
};

export const fetchInvoices = async () => {
    try {
        const response = await apiClient.get('/invoices/getAllInvoices');
        return response.data;
    } catch (error) {
        console.error('Error fetching invoices:', error);
        throw error;
    }
};

export const createInvoice = async (inoviceData) => {
    try {
        const response = await apiClient.post('/invoices/createInvoice', inoviceData);
        return response.data;
    } catch (error) {
        console.error('Error creating invoice:', error);
        throw error;
    }
};

export const removeInvoice = async (invoiceId) => {
    try {
        const response = await apiClient.delete(`/invoices/removeInvoice/${invoiceId}`);
        return response.data;
    } catch (error) {
        console.error('Error deleting invoice with id: ' + invoiceId, error);
        throw error;
    }
};

//Role requests--------------------------------------------------------------------

export const fetchRole = async (roleId) => {
    try {
        const response = await apiClient.get(`/roles/getRoleById/${roleId}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching role with id: ' + roleId, error);
        throw error;
    }
};

export const fetchRoles = async () => {
    try {
        const response = await apiClient.get('/roles/getAllRoles');
        return response.data;
    } catch (error) {
        console.error('Error fetching roles:', error);
        throw error;
    }
};


export default apiClient;