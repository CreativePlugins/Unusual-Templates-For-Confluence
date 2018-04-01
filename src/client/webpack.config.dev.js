require('babel-polyfill');
const webpack = require('webpack');
const path = require('path');

module.exports = {
    entry: {
        t4confluence: [
            './react/app.js'
        ]
    },

    output: {
        path: path.join(__dirname, 'react'),
        filename: '../../main/resources/js/[name].pack.js'
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: [/node_modules/],
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/env', '@babel/react'],
                        plugins: [
                            ["@babel/transform-runtime", {
                                "helpers": false,
                                "polyfill": true,
                                "regenerator": true,
                                "moduleName": "babel-runtime"
                            }],
                            ["import", { "libraryName": "antd", "libraryDirectory": "es", "style": "css" }]
                        ]
                    },
                }],
            },
            {
                test: /\.json$/,
                use: [
                    'json-loader'
                ]
            },
            {
                test: /\.css$/,
                use: [ 'style-loader', 'css-loader' ]
            }
        ]
    }
};